package Utilities;

import org.monte.media.Format;
import org.monte.media.math.Rational;
import org.monte.screenrecorder.ScreenRecorder;

import java.awt.*;
import java.io.File;
import java.nio.file.Files;
import java.nio.file.Paths;
import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

import static org.monte.media.FormatKeys.*;
import static org.monte.media.VideoFormatKeys.ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE;

public class VideoRecorderUtil {

    private static ScreenRecorder recorder;

    public static void startRecording(String testName) throws Exception {
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("yyyyMMdd_HHmmss");
        String timestamp = LocalDateTime.now().format(formatter);
        int counter = 1;
        String folderName;
        do {
            folderName = String.format("failedTestsVi_%s_%03d", timestamp, counter);
            counter++;
        } while (Files.exists(Paths.get("src/main/resources/" + folderName)));


        recorder = new ScreenRecorder(
                GraphicsEnvironment.getLocalGraphicsEnvironment()
                        .getDefaultScreenDevice()
                        .getDefaultConfiguration(),
                new Rectangle(Toolkit.getDefaultToolkit().getScreenSize()),
                new Format(MediaTypeKey, MediaType.FILE, MimeTypeKey, MIME_AVI),
                new Format(MediaTypeKey, MediaType.VIDEO, EncodingKey, ENCODING_AVI_TECHSMITH_SCREEN_CAPTURE,
                        FrameRateKey, Rational.valueOf(15)),
                null,
                null,
                new File(folderName));
        recorder.start();
    }

    public static void stopRecording() throws Exception {
        recorder.stop();
    }
}
