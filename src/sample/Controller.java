package sample;

import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.Button;
import javafx.scene.control.Label;


import java.time.Duration;
import java.time.LocalDateTime;
import java.util.*;

public class Controller {

    private List<Integer> sorsoltSzamokListaja = new ArrayList<>();
    private final Random random = new Random();
    private int kisorsoltSzam;

    @FXML
    public Button btnSorsolasRendezes;
    @FXML
    public Label lblSorsoltSzam;
    @FXML
    public Label kisorsoltszam1;
    @FXML
    public Label kisorsoltszam2;
    @FXML
    public Label kisorsoltszam3;
    @FXML
    public Label kisorsoltszam4;
    @FXML
    public Label kisorsoltszam5;
    private Timer timer;




    public void SorsolasClick() {
        sorsolosVeletlenSzamGenerator();
        sorsol();
        veletlensorsolo();
        //rendez();
    }

    private int sorsolosVeletlenSzamGenerator() {
        kisorsoltSzam = random.nextInt(90) + 1;
        return kisorsoltSzam;
    }

    private void sorsol() {
        timer = new Timer();
        TimerTask timerTask = new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() -> lblSorsoltSzam.setText(Integer.toString(random.nextInt(90) + 1)));
            }

        };
        timer.scheduleAtFixedRate(timerTask, 0, 10);
        Timer timerMasik = new Timer();
        TimerTask ujTimerTask = new TimerTask() {

            @Override
            public void run() {
                timer.cancel();
                Platform.runLater(() -> lblSorsoltSzam.setText(Integer.toString(kisorsoltSzam)));
            }
        };
        timerMasik.schedule(ujTimerTask, 1500);
        sorsoltSzamokListaja.add(kisorsoltSzam);


        for (int i = 0; i < sorsoltSzamokListaja.size(); i++) {
            kisorsoltszam1.setText(Integer.toString(sorsoltSzamokListaja.get(0)));
            kisorsoltszam2.setText(Integer.toString(sorsoltSzamokListaja.get(1)));
            kisorsoltszam3.setText(Integer.toString(sorsoltSzamokListaja.get(2)));
            kisorsoltszam4.setText(Integer.toString(sorsoltSzamokListaja.get(3)));
            kisorsoltszam5.setText(Integer.toString(sorsoltSzamokListaja.get(4)));
        }

    }


    private void veletlensorsolo() {
        if (sorsoltSzamokListaja.size() <= 5 ) {
            for (int i = 0; i < sorsoltSzamokListaja.size(); i++) {
                kisorsoltszam1.setText(Integer.toString(sorsoltSzamokListaja.get(0)));
                kisorsoltszam2.setText(Integer.toString(sorsoltSzamokListaja.get(1)));
                kisorsoltszam3.setText(Integer.toString(sorsoltSzamokListaja.get(2)));
                kisorsoltszam4.setText(Integer.toString(sorsoltSzamokListaja.get(3)));
                kisorsoltszam5.setText(Integer.toString(sorsoltSzamokListaja.get(4)));
            }
            btnSorsolasRendezes.setText("Rendez");
            sorsoltSzamokListaja.sort(Comparator.naturalOrder());
        }

        else if (btnSorsolasRendezes.getText() == "Rendez") {
            for (int i = 0; i < sorsoltSzamokListaja.size(); i++) {
                kisorsoltszam1.setText(Integer.toString(sorsoltSzamokListaja.get(0)));
                kisorsoltszam2.setText(Integer.toString(sorsoltSzamokListaja.get(1)));
                kisorsoltszam3.setText(Integer.toString(sorsoltSzamokListaja.get(2)));
                kisorsoltszam4.setText(Integer.toString(sorsoltSzamokListaja.get(3)));
                kisorsoltszam5.setText(Integer.toString(sorsoltSzamokListaja.get(4)));
            }
            btnSorsolasRendezes.setText("Sorsol");
            sorsoltSzamokListaja.clear();
            lblSorsoltSzam.setText("");
            kisorsoltszam1.setText("");
            kisorsoltszam2.setText("");
            kisorsoltszam3.setText("");
            kisorsoltszam4.setText("");
            kisorsoltszam5.setText("");
        }







    }






}
