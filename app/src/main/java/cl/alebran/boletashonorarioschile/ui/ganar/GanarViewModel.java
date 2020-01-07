package cl.alebran.boletashonorarioschile.ui.ganar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cl.alebran.boletashonorarioschile.calculo.Calculo;

public class GanarViewModel extends ViewModel {

    private MutableLiveData<Long> valorLiquido;
    private MutableLiveData<Long> valorNetoLiquido;
    private MutableLiveData<Long> impuestoBoletaLiquido;


    public GanarViewModel() {
        valorLiquido = new MutableLiveData<>();
        valorNetoLiquido = new MutableLiveData<>();
        impuestoBoletaLiquido = new MutableLiveData<>();
        valorLiquido.setValue(0l);
        valorNetoLiquido.setValue(0l);
        impuestoBoletaLiquido.setValue(0l);
    }


    public MutableLiveData<Long> getValorLiquido(){
        return valorLiquido;
    }

    public void calcular(Integer valorInicial){
        long valor = Calculo.calcularLiquido(valorInicial);
        valorNetoLiquido.setValue(Long.valueOf(valorInicial));
        valorLiquido.setValue(valor);
        impuestoBoletaLiquido.setValue(Math.round(valor*0.1075));
    }

    public MutableLiveData<Long> getValorNetoLiquido(){
        return valorNetoLiquido;
    }

    public MutableLiveData<Long> getImpuestoBoletaLiquido(){
        return impuestoBoletaLiquido;
    }


}
