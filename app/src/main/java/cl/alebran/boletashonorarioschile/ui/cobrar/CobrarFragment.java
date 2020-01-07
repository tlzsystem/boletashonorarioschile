package cl.alebran.boletashonorarioschile.ui.cobrar;

import androidx.lifecycle.ViewModelProviders;

import android.os.Bundle;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import android.text.Editable;
import android.text.TextWatcher;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.TextView;

import cl.alebran.boletashonorarioschile.R;

public class CobrarFragment extends Fragment {

    private CobrarViewModel mViewModel;

    public static CobrarFragment newInstance() {
        return new CobrarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        return inflater.inflate(R.layout.cobrar_fragment, container, false);
    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(CobrarViewModel.class);



        final EditText editCobrar = getActivity().findViewById(R.id.editCobrar);
        final TextView txtvalorGanancia = getActivity().findViewById(R.id.txtvalorGanancia);
        final TextView txtValor_cobrar = getActivity().findViewById(R.id.txtValor_cobrar);
        final TextView txtImpuesto_cobrar = getActivity().findViewById(R.id.txtImpuesto_cobrar);
        final TextView txtGanancia_cobrar =  getActivity().findViewById(R.id.txtGanancia_cobrar);

        editCobrar.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {

            }

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

            }

            @Override
            public void afterTextChanged(Editable s) {
                mViewModel.calcular(s.length()>0?Integer.valueOf(s.toString()):0);
            }
        });

        mViewModel.getImpuestoBoleta().observe(this, valor->{
                txtImpuesto_cobrar.setText("Impuesto: $"+String.format("%,d", valor));
        });

        mViewModel.getValorGanancia().observe(this, valor->{
            txtvalorGanancia.setText("$"+String.format("%,d", valor));
            txtGanancia_cobrar.setText("Ganancia: $"+String.format("%,d", valor));
        });

        mViewModel.getValorNeto().observe(this, valor->{
            txtValor_cobrar.setText("Boleta: $"+ String.format("%,d", valor));
        });

    }

}
