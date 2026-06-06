package org.example.simplemediaplayer;

public class SimpleMediaPlayer {
//  Requirements
//  1. Support MP3, VLC and WAV formats.
//  2. Handle unsupported formats gracefully.


//    song.mp3  = MP3 Player
//    movie.vlc = VLC Player
//    audio.wav = WAV Player

//    If an unsupported file is given: video.mp4. The system should display an appropriate message.

//    My first thought was to use if-else conditions based on the file format.

//    public void play(String format) {
//        if(format.equals("mp3")) {
//            new Mp3Player().play();
//        }
//        else if(format.equals("vlc")) {
//            new VlcPlayer().play();
//        }
//        else if(format.equals("wav")) {
//            new WavPlayer().play();
//        }
//    }

//    Problems we might face with this approach
//    As more media formats are added, the if-else conditions continue to grow.
//    MP3
//    WAV
//    VLC
//    MP4 etc...

//    Every new format requires modifications to the existing code.
//    The object creation logic is also mixed with the playback logic.


//    The main thing changing here is the type of media player object being created.
//    Different formats require different player implementations.

//    The client should not be responsible for deciding which player object to create. So we can use the Factory Pattern.

//    A common interface is created for all media players.
//    interface MediaPlayer {
//        void play();
//    }

//    Mp3Player
//    VlcPlayer
//    WavPlayer

//    The factory creates the correct player based on the format.

//    MediaPlayer player = MediaPlayerFactory.getPlayer("mp3");
//    player.play();

//    The client works only with the MediaPlayer interface.
//    for unsupported formats we can use like this..
//    throw new IllegalArgumentException("Unsupported format");


//    1. Factory Pattern.
//    2. Because the media player object depends on the file format. Factory Pattern centralizes object creation and keeps
//    the client code independent of concrete player implementations.
//    3. Use if-else conditions directly in the client.
}
