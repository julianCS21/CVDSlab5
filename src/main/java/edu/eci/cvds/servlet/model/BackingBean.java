package edu.eci.cvds.servlet.model;
import javax.annotation.ManagedBean;
import javax.enterprise.context.ApplicationScoped;
import java.util.Random;
import javax.enterprise.context.SessionScoped;
import javax.faces.event.ActionEvent;


@ManagedBean(value = "guessBean")

@ApplicationScoped
public class BackingBean {



    private int randomNumber;

    private int attemptNumber;

    private int attempts;

    private int prize;

    private String gameState;

    public BackingBean(){
        Random ran = new Random();
        this.randomNumber = ran.nextInt();
        this.attempts = 0;
        this.attemptNumber = 0;
        this.prize = 100000;
        this.gameState = "NO HA GANADO";
    }


    public int getRandomNumber() {
        return randomNumber;
    }

    public int getAttemptNumber() {
        return attemptNumber;
    }

    public void setAttemptNumber(int attemptNumber) {
        this.attemptNumber = attemptNumber;
    }

    public void setRandomNumber(int randomNumber) {
        this.randomNumber = randomNumber;
    }

    public int getAttempts() {
        return attempts;
    }

    public void setAttempts(int attempts) {
        this.attempts = attempts;
    }

    public int getPrize() {
        return prize;
    }

    public void setPrize(int prize) {
        this.prize = prize;
    }

    public String getGameState() {
        return gameState;
    }

    public void setGameState(String gameState) {
        this.gameState = gameState;
    }

    public void guess (ActionEvent actionEvent){
        this.attempts+= 1;
        if(this.attemptNumber == this.randomNumber){
            this.gameState = "FELICIDADES A GANADO, PREMIO TOTAL : " + getPrize();
        }
        else{
            this.prize -= 10000;
        }



    }

    public void restart(ActionEvent actionEvent){
        setPrize(100000);
        this.attempts = 0;
    }


}
