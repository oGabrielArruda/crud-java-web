import WebService.ClienteWS;
import InfoCidade.InfoCidade;
import Logradouro.Logradouro;

import java.io.BufferedReader;
import java.io.InputStreamReader;

public class Main
{
    public static void main(String[] args)
    {
        BufferedReader Teclado = new BufferedReader(new InputStreamReader(System.in));
        int opcaoDesejada = 0;
        try
        {
            do{
                System.out.println("CRUD EXAMPLE LOJAS");
                System.out.println("Selecione a opção desejada");
                System.out.println("1- Inserir loja    (Create)");
                System.out.println("2- Selecionar loja (Read)");
                System.out.println("3- Alterar loja    (Update)");
                System.out.println("4- Excluir loja    (Delete)");
                System.out.println("99- Excluir loja");
                opcaoDesejada = Integer.parseInt(Teclado.readLine());
                if(opcaoDesejada < 0 || opcaoDesejada > 4)
                    continue;

                switch (opcaoDesejada)
                {
                    case 1:
                }

            } while (opcaoDesejada != 99);

        }
        catch (Exception ex)
        {
              ex.printStackTrace();
        }
    }
}
