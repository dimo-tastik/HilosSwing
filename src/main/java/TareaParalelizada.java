import javax.swing.*;

public class TareaParalelizada extends SwingWorker<String, Integer> {
    /* Barra de progreso que la tarea irá actualizando a medida
    que los cálculos progresen */
    JProgressBar pbBarraProgreso;
    /*Intervalo de números que se van a sumar*/
    int min, max;
    /*Constructor*/
    public TareaParalelizada(JProgressBar pbBarraProgreso, int min, int max) {
        this.pbBarraProgreso = pbBarraProgreso;
        this.min = min;
        this.max = max;
    }
    @Override
    protected String doInBackground() throws Exception {
 /*Avisamos a la barra de cuales son los valores más pequeños
 y más grandes que se van a recorrer */
        this.pbBarraProgreso.setMaximum(max);
        this.pbBarraProgreso.setMinimum(min);
        int suma=0;
        /*Recorremos los números...*/
        for (int i=0; i<2000; i++){
            suma=suma+i;
            Thread.sleep(1);
 /*...y actualizamos la barra para que el usuario pueda
 ir viendo el progreso*/
            this.pbBarraProgreso.setValue(i);
        }
        return "Sumado:"+suma;
    }
}
