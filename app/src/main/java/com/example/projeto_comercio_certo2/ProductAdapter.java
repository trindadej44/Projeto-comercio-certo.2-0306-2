package com.example.projeto_comercio_certo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;
import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    private List<Product> productList;

    public ProductAdapter(List<Product> productList) {
        this.productList = productList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ProductViewHolder holder, final int position) {
        final Product product = productList.get(position);
        holder.bind(product);

        // OnClickListener para o ícone "x" para remover o item
        holder.imageViewRemove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                productList.remove(position);
                notifyDataSetChanged(); // Notificar o RecyclerView que os dados foram alterados
            }
        });
    }

    @Override
    public int getItemCount() {
        return productList.size();
    }

    public static class ProductViewHolder extends RecyclerView.ViewHolder {
        TextView txtProductName;
        TextView txtProductDescription;
        TextView txtProductPrice;
        ImageView imageViewRemove;

        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);
            txtProductName = itemView.findViewById(R.id.txtProductName);
            txtProductDescription = itemView.findViewById(R.id.txtProductDescription);
            txtProductPrice = itemView.findViewById(R.id.txtProductPrice);
            imageViewRemove = itemView.findViewById(R.id.imageViewRemove);
        }

        public void bind(Product product) {
            txtProductName.setText(product.getName());
            txtProductDescription.setText(product.getDescription());
            txtProductPrice.setText(String.valueOf(product.getPrice()));
        }
    }
}
