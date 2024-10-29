package com.example.listview;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.listview.model.UserModel;
import java.util.List;

public class UserAdapter extends ArrayAdapter<UserModel> {

    private LayoutInflater inflater;  // для создания макета(view) элемента из XML-файла
    private int layout;  // id ресурса макета, который описывает, как должен выглядеть каждый элемент списка
    private List<UserModel> usersModel;  // список объектов, которые будут отображаться

    public UserAdapter(Context context, int resource, List<UserModel> usersModel) {
        super(context, resource, usersModel);

        // LayoutInflater — класс, использ. для создания объектов представления(View) из XML-файлов макетов
        this.inflater = LayoutInflater.from(context);

        this.layout = resource;
        this.usersModel = usersModel;
    }

    public View getView(int position, View convertView, ViewGroup parent) {
        // position - индекс текущего элемента списка
        // convertView - представление элемента списка, которое может быть повторно использовано
        // parent — родительский элемент (ListView или RecyclerView)

        // viewHolder будет использ. для хранения ссылок на элементы интерфейса, чтобы их можно было
        // повторно использовать без повторного поиска
        ViewHolder viewHolder;

        // существует ли convertView (ранее созданное представление для этого элемента)
        if (convertView == null) {
            // представление создаём с нуля
            convertView = inflater.inflate(this.layout, parent, false);

            // сохраняет viewHolder в convertView в виде тега, чтобы можно было извлечь позже,
            // если представление будет повторно использоваться
            viewHolder = new ViewHolder(convertView);
            convertView.setTag(viewHolder);
        }
        else {
            // используем представление повторно, и создание нового представления не требуется
            viewHolder = (ViewHolder) convertView.getTag();
        }

        UserModel userModel = usersModel.get(position);  // получаем объект UserModel

        // устанавливаем значения для элементов интерфейса в viewHolder с помощью данных, содержащихся
        // в объекте userModel для текущего элемента списка
        viewHolder.avatarView.setImageResource(userModel.getIdAvatar());
        viewHolder.nameView.setText(userModel.getSurname() + " " + userModel.getName());
        viewHolder.countryView.setText(userModel.getCountry() + ", " + userModel.getCity());
        viewHolder.ageView.setText(String.valueOf(userModel.getAge()));

        return convertView;  // convertView, которое содержит все данные текущего элемента списка
    }

    // внутренний класс, использ. для оптимизации работы адаптера UserAdapter
    /*
    Когда адаптер отображает длинный список, ListView/RecyclerView многократно создает и повторно использ. представления
    ViewHolder помогает сократить число вызовов findViewById, сохраняя ссылки на элементы View в каждой строке списка
    Вместо поиска представлений по ID каждый раз, адаптер просто использует уже сохраненные ссылки, что ускоряет процесс
    */
    private class ViewHolder {

        final ImageView avatarView;
        final TextView nameView;
        final TextView countryView;
        final TextView ageView;

        ViewHolder(View view) {
            avatarView = view.findViewById(R.id.avatar);
            nameView = view.findViewById(R.id.name);
            countryView = view.findViewById(R.id.country);
            ageView = view.findViewById(R.id.age);
        }
    }
}