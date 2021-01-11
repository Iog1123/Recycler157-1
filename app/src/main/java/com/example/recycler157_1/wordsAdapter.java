package com.example.recycler157_1;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.recycler157_1.databinding.WordItemListBinding;

import java.util.List;

// 3. extemder  de recycler adapter  pasando el viewholder que creamos
// 4. implementar los 3 metodos
public class wordsAdapter extends RecyclerView.Adapter<wordsAdapter.wordViewHolder> {
    // se crea una lsita de estring que contendrán  los datos
private List<String> mWordList;
// referencia a la interface



public wordsAdapter(List<String>mWordList){
    this.mWordList=mWordList;
}

    @NonNull
    @Override
    public wordViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        // 6  INSTANCIAMOS viewbinding para retornar el view holder
       WordItemListBinding mBinding= WordItemListBinding.inflate(LayoutInflater.from(parent.getContext()),parent,false);
        return new wordViewHolder(mBinding);
    }

    @Override
    public void onBindViewHolder(@NonNull wordViewHolder holder, int position) {
        // 7 se crea una variable para hcaer una referencia del objeto por la posicion y lo asignamos
        // a la vista de su viewholder
        String word= mWordList.get(position);
        holder.txtView.setText(word);
    }

    @Override
    public int getItemCount() {
        // 5 indicar que retorna  el tamaño del lisaDO
        return mWordList.size();
    }


    // crear clase interna llamada XXXViewHolder

    public class wordViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener{
        public TextView txtView;
        public wordViewHolder (@NonNull WordItemListBinding mBinding) {
            super(mBinding.getRoot());
            txtView=mBinding.textView;
            itemView.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            int position= getLayoutPosition();
            String element=mWordList.get(position);
            //Toast.makeText(v.getContext(),element,Toast.LENGTH_SHORT).show();
            mWordList.set(position,element+ "click");
            notifyDataSetChanged();
        }
    }
}
