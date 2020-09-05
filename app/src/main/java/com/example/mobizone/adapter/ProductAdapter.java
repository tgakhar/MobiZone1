package com.example.mobizone.adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.navigation.NavController;
import androidx.recyclerview.widget.RecyclerView;

import com.example.mobizone.R;
import com.example.mobizone.model.Products;
import com.example.mobizone.view.ProductdetailsActivity;
import com.squareup.picasso.Picasso;

import java.util.List;

public class ProductAdapter extends RecyclerView.Adapter<ProductAdapter.ProductViewHolder> {

    Context context;
    List<Products> productsList;
    NavController navController;

    public ProductAdapter(Context context, List<Products> productsList) {
        this.context = context;
        this.productsList = productsList;
    }

    @NonNull
    @Override
    public ProductViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {

        View view = LayoutInflater.from(context).inflate(R.layout.layout_product, parent, false);
        return new ProductViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull final ProductViewHolder holder, final int position) {
        Picasso.get().load(productsList.get(position).getImageUrl()).into(holder.prodImage);
        holder.prodName.setText(productsList.get(position).getProductName());
        holder.prodPrice.setText(productsList.get(position).getProductPrice());
        holder.prodMemory.setText(productsList.get(position).getMemory());

        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent i = new Intent(context, ProductdetailsActivity.class);


                Bundle b = new Bundle();
                String name=productsList.get(position).getProductName();
                String company=productsList.get(position).getCompany();
                String memory=productsList.get(position).getMemory();
                String price=productsList.get(position).getProductPrice();
                int id=productsList.get(position).getProductid();
                String image_detail=productsList.get(position).getImage_detail();
                String processor=productsList.get(position).getProcessor();
                String battery=productsList.get(position).getBattery();
                String frntCam=productsList.get(position).getFrntCam();
                String bckCam=productsList.get(position).getBckCam();
                String os=productsList.get(position).getOs();
                b.putString("Name",name);
                b.putString("Company",company);
                b.putString("Memory",memory);
                b.putString("Price",price);
                b.putString("Processor",processor);
                b.putString("Battery",battery);
                b.putString("Front",frntCam);
                b.putString("Back",bckCam);
                b.putString("Os",os);
                b.putInt("id", id);
                b.putString("Image", String.valueOf(image_detail));
                i.putExtras(b);
                context.startActivity(i);
            }
        });
    }

    @Override
    public int getItemCount() {
        return productsList.size();
    }

    public static final class ProductViewHolder extends RecyclerView.ViewHolder{

        ImageView prodImage;
        TextView prodName, prodPrice,prodMemory;


        public ProductViewHolder(@NonNull View itemView) {
            super(itemView);


            prodImage = itemView.findViewById(R.id.prod_image);
            prodName = itemView.findViewById(R.id.prod_name);
            prodPrice = itemView.findViewById(R.id.prod_price);
            prodMemory = itemView.findViewById(R.id.prod_memory);


        }
    }

}
