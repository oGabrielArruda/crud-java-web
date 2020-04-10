import WebService.ClienteWS;
import InfoCidade.InfoCidade;
import InfoCidade.InfoEstado.InfoEstado;

public class Main
{
    public static void main(String[] args)
    {
        try
        {
            InfoEstado logradouro = (InfoEstado) ClienteWS.getObjeto(InfoEstado.class, "http://api.postmon.com.br/v1/cep", "13035350");
            System.out.println (logradouro);
        }
        catch (Exception erro)
        {
            System.err.println (erro.getMessage());
        }
    }
}
