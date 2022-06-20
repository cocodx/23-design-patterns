package liug.ds.learn.structure.adapter;

import lombok.Data;
import lombok.ToString;

import java.io.*;
import java.nio.file.Files;
import java.util.ArrayList;
import java.util.List;

/**
 * @author amazfit
 * @date 2022-06-20 下午7:50
 **/
public class AdapterPraticeDay2 {

    @Data
    @ToString
    public static class LogModel{
        private String logId;
        private String operateUser;
        private String operateTime;
        private String logContent;
    }


    public static interface LogFileOperateApi{
        List<LogModel> readLogFile();
        void writeLogFile(List<LogModel> list);
    }

    public static class LogFileOperate implements LogFileOperateApi{
        private String logFilePathName = "D://AdapterLog.log";

        public LogFileOperate(String logFilePathName) {
            if (logFilePathName!=null && logFilePathName.trim().length()>0){
                this.logFilePathName = logFilePathName;
            }
        }

        @Override
        public List<LogModel> readLogFile() {
            List<LogModel> list = null;
            ObjectInputStream objectInputStream = null;
            try{
                File file = new File(logFilePathName);
                if (file.exists()){
                    objectInputStream = new ObjectInputStream(new BufferedInputStream(Files.newInputStream(file.toPath())));
                    list = (List<LogModel>) objectInputStream.readObject();
                }
            }catch (Exception e){
                e.printStackTrace();
            }finally {
                try{
                    if (objectInputStream!=null){
                        objectInputStream.close();
                    }
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
            return list;
        }

        @Override
        public void writeLogFile(List<LogModel> list) {
            File file = new File(logFilePathName);
            ObjectOutputStream outputStream = null;
            try{
                outputStream = new ObjectOutputStream(new BufferedOutputStream(Files.newOutputStream(file.toPath())));
                outputStream.writeObject(list);
            }catch (IOException e){
                e.printStackTrace();
            }finally {
                try{
                    outputStream.close();
                }catch (IOException e){
                    e.printStackTrace();
                }
            }
        }
    }

    public static void main(String[] args) {
        LogModel logModel = new LogModel();
        logModel.setLogId("001");
        logModel.setOperateUser("admin");
        logModel.setOperateTime("2022-06-10 10:12:12");
        logModel.setLogContent("this is a test");

        List<LogModel> list = new ArrayList<>();
        list.add(logModel);
        LogFileOperateApi api = new LogFileOperate("");
        api.writeLogFile(list);

        List<LogModel> readLog = api.readLogFile();
        System.out.println("readLog:"+readLog);
    }
}
