import WebService.ClienteWS;
import InfoCidade.InfoCidade;
import Logradouro.Logradouro;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            Logradouro logradouro = (Logradouro) ClienteWS.getObjeto(Logradouro.class, "http://api.postmon.com.br/v1/cep", "13035350");
            System.out.println (logradouro);
        }
        catch (Exception erro)
        {
            System.err.println (erro.getMessage());
        }
    }
}
