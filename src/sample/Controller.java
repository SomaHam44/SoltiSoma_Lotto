package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.ListView;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Controller {
    private List<Integer> sorsoltSzamokListaja = new ArrayList<>();
    private int kisorsoltSzam;
    private String kisorsoltSzamString;
    private int kihuzottakSzama;



    @FXML
    public Button btnSorsolasRendezes;
    @FXML
    public ListView listHuzottSzamok;
    @FXML
    public Label lblSorsoltSzam;

    private Timer timer;

    public void init() {
        kihuzottakSzama = 0;
    }


    public void SorsolasClick(ActionEvent actionEvent) {
        if (kihuzottakSzama > 0 && kihuzottakSzama < 6)
        sorsol();
        else if (kihuzottakSzama == 5) {
            rendez();
        }

    }

    private void sorsol() {
        for (int i = 0; i < 91; i++) {
            sorsoltSzamokListaja.add(i);
        }

        kisorsoltSzam = (int) Math.random() * sorsoltSzamokListaja.size() - 1;
        kisorsoltSzam = Integer.parseInt(kisorsoltSzamString);
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime aktualis = LocalDateTime.now();
                Duration meddig = Duration.between(LocalDateTime.now(), aktualis);
                Platform.runLater(() -> lblSorsoltSzam.setText(kisorsoltSzamString));





            }

        };
        timer.schedule(timerTask, 1, 1);






    }

    private void rendez() {
        btnSorsolasRendezes.setText("Rendez");


    }
}
