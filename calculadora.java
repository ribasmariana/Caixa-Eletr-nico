import java.util.ArrayList;
import java.util.Scanner;
public class calculadora {
    public static void main(String[] args){
        Scanner s = new Scanner(System.in);

        int [] cedulas = {100, 50, 20, 10, 5, 2, 1};
        int [] qtdcedulas = {1, 2, 1, 0, 0, 0, 1};

        int valorTotal = 0;

        for(int y = 0;y<7;y++) {
            valorTotal +=  cedulas[y] * qtdcedulas[y];
        }

        System.out.println("Temos no caixa: " + valorTotal + " reais.");

        int quantidadeTotal = 0;

        System.out.println("Qual valor deseja sacar?");
        int valorReais = Integer.parseInt(s.nextLine());

        if (valorReais>valorTotal){
            System.out.println("Não temos dinheiro o sufiente para esse saque.");
        }

        else{
            int[] qtdcedulasDisponiveis = qtdcedulas.clone();

            System.out.println("");

            for (int i=0;i< cedulas.length;i++){
                int quantidadeCedulas = Math.min(valorReais / cedulas[i], qtdcedulasDisponiveis[i]);
                System.out.println("Quantidade de cedulas de " + cedulas[i] + ": " + quantidadeCedulas);

                valorReais -= cedulas[i] * quantidadeCedulas;

                qtdcedulasDisponiveis[i] -= quantidadeCedulas;

                quantidadeTotal +=quantidadeCedulas;
            }
            System.out.println("");
            System.out.println("Quantidade total de cédulas: " + quantidadeTotal);
        }
    }}
