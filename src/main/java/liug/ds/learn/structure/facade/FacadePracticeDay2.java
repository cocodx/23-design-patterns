package liug.ds.learn.structure.facade;

import lombok.Data;

/**
 * @author amazfit
 * @date 2022-06-19 下午4:03
 * 没有用外观模式
 **/
public class FacadePracticeDay2 {

    @Data
    public static class ConfigModel{
        //是否需要生成表现层
        private boolean needGenPresentation = true;
        //是否需要生成逻辑层
        private boolean needGenBusiness = true;
        //是否需要生成DAO
        private boolean needGenDao=true;
    }

    public static class ConfigManager{
        private static ConfigManager manager=null;
        private static ConfigModel configModel=null;
        private ConfigManager(){}

        public static ConfigManager getInstance(){
            if (manager==null){
                manager = new ConfigManager();
                configModel=new ConfigModel();
            }
            return manager;
        }

        public ConfigModel getConfigModelData(){
            return configModel;
        }
    }

    public static class Presentation{
        public void generate(){
            ConfigModel configModel = ConfigManager.getInstance().getConfigModelData();
            if (configModel.isNeedGenPresentation()){
                System.out.println("正在生成表现层代码");
            }
        }
    }

    public static class Business{
        public void generate(){
            ConfigModel configModel = ConfigManager.getInstance().getConfigModelData();
            if (configModel.isNeedGenBusiness()){
                System.out.println("正在生成逻辑层代码");
            }
        }
    }

    public static class DAO{
        public void generate(){
            ConfigModel configModel = ConfigManager.getInstance().getConfigModelData();
            if (configModel.isNeedGenDao()){
                System.out.println("正在生成数据层代码");
            }
        }
    }

    public static void main(String[] args) {
        new Presentation().generate();;
        new Business().generate();
        new DAO().generate();
    }
}
