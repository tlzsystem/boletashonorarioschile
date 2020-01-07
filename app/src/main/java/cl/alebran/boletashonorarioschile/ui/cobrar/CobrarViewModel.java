package cl.alebran.boletashonorarioschile.ui.cobrar;

import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import cl.alebran.boletashonorarioschile.calculo.Calculo;

public class CobrarViewModel extends ViewModel {
    private MutableLiveData<Long> valorGanancia;
    private MutableLiveData<Long> impuestoBoleta;
    private MutableLiveData<Long> valorNeto;

    public CobrarViewModel() {

        valorGanancia = new MutableLiveData<>();
        impuestoBoleta = new MutableLiveData<>();
        valorNeto = new MutableLiveData<>();
        valorGanancia.setValue(0l);
        impuestoBoleta.setValue(0l);
        valorNeto.setValue(0l);

    }

    public void calcular(Integer valor){

        long impuesto = Calculo.getValorImpuesto(valor);

        impuestoBoleta.setValue(impuesto);
        valorGanancia.setValue(valor - impuesto);
        valorNeto.setValue((long)valor);

    }

    public MutableLiveData<Long> getValorGanancia() {
        return valorGanancia;
    }

    public MutableLiveData<Long> getImpuestoBoleta() {
        return impuestoBoleta;
    }

    public MutableLiveData<Long> getValorNeto() {
        return valorNeto;
    }
}
