package cl.alebran.boletashonorarioschile.ui.ganar;

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

public class GanarFragment extends Fragment {

    private GanarViewModel mViewModel;


    public static GanarFragment newInstance() {
        return new GanarFragment();
    }

    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container,
                             @Nullable Bundle savedInstanceState) {
        View root = inflater.inflate(R.layout.ganar_fragment, container, false);



        return root;

    }

    @Override
    public void onActivityCreated(@Nullable Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        mViewModel = ViewModelProviders.of(this).get(GanarViewModel.class);

        final EditText editValor = getActivity().findViewById(R.id.editGanar);
        final TextView textValorLiquido = getActivity().findViewById(R.id.textValorLiquido);
        final TextView txtValor_ganar = getActivity().findViewById(R.id.txtValor_ganar);
        final TextView txtImpuesto_ganar = getActivity().findViewById(R.id.txtImpuesto_ganar);

        editValor.addTextChangedListener(new TextWatcher() {
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




        mViewModel.getValorLiquido().observe(this, valor->{
            textValorLiquido.setText("$"+ String.format("%,d", valor));
        });

        mViewModel.getValorNetoLiquido().observe(this, valor ->{
            txtValor_ganar.setText("Ganancia: $"+String.format("%,d", valor));
        });
        mViewModel.getImpuestoBoletaLiquido().observe(this, valor->{
            txtImpuesto_ganar.setText("Impuesto: $"+String.format("%,d",valor));
        });




    }

}
