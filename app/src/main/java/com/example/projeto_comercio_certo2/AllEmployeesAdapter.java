package com.example.projeto_comercio_certo2;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class AllEmployeesAdapter extends RecyclerView.Adapter<AllEmployeesAdapter.EmployeeViewHolder> {

    private List<Employee> employeeList;

    public AllEmployeesAdapter(List<Employee> employeeList) {
        this.employeeList = employeeList;
    }

    @NonNull
    @Override
    public EmployeeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_employee, parent, false);
        return new EmployeeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull EmployeeViewHolder holder, int position) {
        Employee employee = employeeList.get(position);
        holder.bind(employee);
    }

    @Override
    public int getItemCount() {
        return employeeList.size();
    }

    static class EmployeeViewHolder extends RecyclerView.ViewHolder {

        private TextView txtEmployeeName;
        private TextView txtEmployeeAge;
        private TextView txtEmployeePosition;
        private TextView txtEmployeeSalary;

        public EmployeeViewHolder(@NonNull View itemView) {
            super(itemView);
            txtEmployeeName = itemView.findViewById(R.id.txtEmployeeName);
            txtEmployeeAge = itemView.findViewById(R.id.txtEmployeeAge);
            txtEmployeePosition = itemView.findViewById(R.id.txtEmployeePosition);
            txtEmployeeSalary = itemView.findViewById(R.id.txtEmployeeSalary);
        }

        public void bind(Employee employee) {
            txtEmployeeName.setText(employee.getName());
            txtEmployeeAge.setText(String.valueOf(employee.getAge()));
            txtEmployeePosition.setText(employee.getPosition());
            txtEmployeeSalary.setText(String.valueOf(employee.getSalary()));
        }
    }
}

