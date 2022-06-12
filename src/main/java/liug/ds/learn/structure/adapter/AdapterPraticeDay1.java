package liug.ds.learn.structure.adapter;

/**
 * @author amazfit
 * @date 2022-06-13 上午6:09
 **/
public class AdapterPraticeDay1 {

    public static interface MediaPlayer{
        public void play(String audioType,String fileName);
    }

    public static interface AdvancedMediaPlayer{
        public void playVlc(String fileName);
        public void playMp4(String fileName);
    }

    public static class Mp4Player implements AdvancedMediaPlayer{

        @Override
        public void playVlc(String fileName) {
            //什么也不做
        }

        @Override
        public void playMp4(String fileName) {
            System.out.println("playing mp4 file. Name:"+fileName);
        }
    }

    public static class VlcPlayer implements AdvancedMediaPlayer{

        @Override
        public void playVlc(String fileName) {
            System.out.println("playing vlc file. Name:"+fileName);
        }

        @Override
        public void playMp4(String fileName) {
            //什么也不做
        }
    }

    public static class MediaAdapter implements MediaPlayer{
        AdvancedMediaPlayer advancedMediaPlayer;

        public MediaAdapter(String audioType) {
            if (audioType.equalsIgnoreCase("vlc")){
                this.advancedMediaPlayer = new VlcPlayer();
            }else if (audioType.equalsIgnoreCase("mp4")){
                this.advancedMediaPlayer = new Mp4Player();
            }
        }

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("vlc")){
                advancedMediaPlayer.playVlc(fileName);
            }else if (audioType.equalsIgnoreCase("mp4")){
                advancedMediaPlayer.playMp4(fileName);
            }
        }
    }

    public static class AudioPlayer implements MediaPlayer{
        MediaPlayer mediaPlayer;

        @Override
        public void play(String audioType, String fileName) {
            if (audioType.equalsIgnoreCase("mp3")){
                System.out.println("playing mp3 file. Name:"+fileName);
            } else if (audioType.equalsIgnoreCase("vlc") || audioType.equalsIgnoreCase("mp4")) {
                mediaPlayer = new MediaAdapter(audioType);
                mediaPlayer.play(audioType, fileName);
            }else {
                System.out.println("Invalid media, "+audioType+" format not supported");
            }
        }
    }

    public static void main(String[] args) {
        AudioPlayer audioPlayer = new AudioPlayer();

        audioPlayer.play("mp3", "beyond the horizon.mp3");
        audioPlayer.play("mp4", "alone.mp4");
        audioPlayer.play("vlc", "far far away.vlc");
        audioPlayer.play("avi", "mind me.avi");
    }

}
