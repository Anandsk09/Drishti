package drishtiCore;

import android.app.Activity;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v7.view.menu.ListMenuItemView;
import android.support.v7.widget.ListViewCompat;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.newpc.drishti.R;
import java.util.List;

public class EmployeeList extends ArrayAdapter<Employee> {

    private Activity context;
    private List<Employee> employeeList;

    public EmployeeList(Activity context,List<Employee> employeeList)
    {
        super(context,R.layout.display_info,employeeList);
        this.context=context;
        this.employeeList=employeeList;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
       // return super.getView(position, convertView, parent);
        LayoutInflater inflater=context.getLayoutInflater();
        View listView=inflater.inflate(R.layout.display_info,null,true);
        TextView textViewname=(TextView) listView.findViewById(R.id.name);
        TextView textViewemail=(TextView) listView.findViewById(R.id.email);
        Employee employee=employeeList.get(position);
        textViewname.setText(employee.getName());
        textViewname.setText(employee.getEmailId());

        return listView;
    }
}
