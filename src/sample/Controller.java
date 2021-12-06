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
    private int kihuzottakSzama;
    private int elsoSzam, masodikSzam, harmadikSzam, negyedikSzam, otodikSzam;

    @FXML
    public Button btnSorsolasRendezes;
    @FXML
    public Label lblSorsoltSzam;
    @FXML
    public Label kisorsoltszam1;
    public Label kisorsoltszam2;
    public Label kisorsoltszam3;
    public Label kisorsoltszam4;
    public Label kisorsoltszam5;
    private Timer timer;

    public void init() {
        kihuzottakSzama = 0;
    }


    public void SorsolasClick(ActionEvent actionEvent) {
        lblSorsoltSzam.setText("" + sorsolosVeletlenSzamGenerator());
        sorsol();

        veletlensorsolo();
        if (kihuzottakSzama > 0 && kihuzottakSzama < 6)
        sorsol();
        else if (kihuzottakSzama == 5) {
            rendez();
        }

    }

    private int sorsolosVeletlenSzamGenerator() {
        for (int i = 0; i < 91; i++) {
            sorsoltSzamokListaja.add(i);
        }

        kisorsoltSzam = (int) (Math.random() * sorsoltSzamokListaja.size() - 1) + 1;
        return kisorsoltSzam;
    }

    private void sorsol() {
        for (int i = 0; i < 91; i++) {
            sorsoltSzamokListaja.add(i);
        }

        kisorsoltSzam = (int) (Math.random() * sorsoltSzamokListaja.size() - 1) + 1;
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                LocalDateTime aktualis = LocalDateTime.now();
                Duration meddig = Duration.between(LocalDateTime.now(), aktualis);
                Platform.runLater(() -> lblSorsoltSzam.setText((int) (Math.random() * 100) + 1 + "" ));
            }

        };
        timer.schedule(timerTask, 2000);
    }

    private void veletlensorsolo() {
        if (kihuzottakSzama == 0) {
            kihuzottakSzama++;
        }
        lblSorsoltSzam.setText(" " + kisorsoltSzam);

    }

    private void rendez() {
        btnSorsolasRendezes.setText("Rendez");


    }
}
