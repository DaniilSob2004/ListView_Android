package com.example.listview;

import android.os.Bundle;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.listview.model.UserModel;
import com.example.listview.utils.AppConstant;
import com.example.listview.utils.TaskFactory;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    ArrayList<UserModel> usersModel = new ArrayList<>();
    ListView usersList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        // начальная инициализация списка
        usersModel = TaskFactory.getUserModels(AppConstant.COUNT_USERS);

        // получаем элемент ListView
        usersList = findViewById(R.id.users_list);

        // создаём адаптер
        UserAdapter userAdapter = new UserAdapter(this, R.layout.user_item, usersModel);

        // устанавливаем адаптер в список
        usersList.setAdapter(userAdapter);

        // создаем слушатель для элемента AdapterView (ListView или RecycleView), который реагирует на клики по элементам списка
        AdapterView.OnItemClickListener itemListener = (parent, v, position, id) -> {
            // parent — это AdapterView (ListView), на котором произошло нажатие
            // v — это View конкретного элемента, на который нажали
            // position — позиция элемента в списке
            // id — идентификатор строки
            UserModel selectedUser = (UserModel)parent.getItemAtPosition(position);
            Toast.makeText(getApplicationContext(), "Choice: " + selectedUser.getName(), Toast.LENGTH_LONG).show();
        };
        usersList.setOnItemClickListener(itemListener);
    }
}