package cl.alebran.boletashonorarioschile.calculo;

public class Calculo {



    public static Long calcularLiquido(Integer valorInicial){
        long valor = Math.round( valorInicial/0.8925);

        return valor;
    }

    public static Long getValorImpuesto(Integer valor){
        return Math.round(valor*0.1075);
    }


}
