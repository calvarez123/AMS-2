package com.example.recicledview;import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import androidx.recyclerview.widget.RecyclerView;

public class CustomAdapter extends RecyclerView.Adapter<CustomAdapter.ViewHolder> {

    private int[] imageDataSet; // Array de recursos de drawable
    private Context context;

    // Constructor
    public CustomAdapter(Context context, int[] dataSet) {
        this.context = context;
        imageDataSet = dataSet;
    }

    // ViewHolder para contener cada elemento de la lista
    public static class ViewHolder extends RecyclerView.ViewHolder {
        private final ImageView imageView;

        public ViewHolder(View view) {
            super(view);
            imageView = view.findViewById(R.id.imageView);
        }

        public ImageView getImageView() {
            return imageView;
        }
    }

    @Override
    public ViewHolder onCreateViewHolder(ViewGroup viewGroup, int viewType) {
        // Crear un nuevo view, que define la interfaz de usuario del elemento de la lista
        View view = LayoutInflater.from(viewGroup.getContext())
                .inflate(R.layout.item_layout, viewGroup, false);

        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(ViewHolder viewHolder, final int position) {
        // Obtener el recurso de drawable en esta posición y establecerlo en el ImageView
        viewHolder.getImageView().setImageResource(imageDataSet[position]);
    }

    @Override
    public int getItemCount() {
        return imageDataSet.length;
    }
}
