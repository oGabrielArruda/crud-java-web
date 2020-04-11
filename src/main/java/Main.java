import Janelas.JanelaCrud;
import WebService.ClienteWS;
import InfoCidade.InfoCidade;
import Logradouro.Logradouro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            JanelaCrud janela = new JanelaCrud();
            janela.setVisible(true);
        }
        catch (Exception e)
        {
            e.printStackTrace();
        }
    }
}
