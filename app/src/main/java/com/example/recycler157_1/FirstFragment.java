package com.example.recycler157_1;

import android.os.Bundle;
import android.renderscript.ScriptGroup;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.navigation.fragment.NavHostFragment;
import androidx.recyclerview.widget.LinearLayoutManager;

import com.example.recycler157_1.databinding.FragmentFirstBinding;

import java.util.ArrayList;
import java.util.List;

public class FirstFragment extends Fragment {

    private FragmentFirstBinding mbinding;
    private  List<String>listado= new ArrayList<>();

    @Override
    public View onCreateView(
            LayoutInflater inflater, ViewGroup container,
            Bundle savedInstanceState
    ) {
        // Inflate the layout for this fragment
        mbinding = FragmentFirstBinding.inflate(inflater,container,false);
        return mbinding.getRoot();
    }

    public void onViewCreated(@NonNull View view, Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        // instanciamos el adapter  y le pasamos el listado de datos
        wordsAdapter madapter= new wordsAdapter(wordList());
        // le pasamos el adapter a nuestro  recycler view
        mbinding.rv.setAdapter(madapter);
        // le indicamos al recycler view como mostrar elementos, podria ser grid, o staggered
        mbinding.rv.setLayoutManager(new LinearLayoutManager(getContext()));
        mbinding.fab4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
            // añadir palabra al listado
                listado.add("palabra"+ listado.size());
                mbinding.rv.getAdapter().notifyItemInserted(listado.size());
                // scroll al final
                mbinding.rv.smoothScrollToPosition(listado.size());
            }
        });

        Log.d("LISTADO", wordList().toString());
    }

    private List<String> wordList(){
        List<String> listado = new ArrayList<>();
        for (int i = 0; i < 50; i++) {
            listado.add("Palabra "+ i);
        }
        return listado;
    }

}