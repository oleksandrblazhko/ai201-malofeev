# Словник атрибутів об’єктів

<table>
    <thead align="center">
        <tr>
            <td>Об'єкт</td>
            <td>Атрибут</td>
            <td>Короткий опис</td>
            <td>Тип</td>
            <td>Обмеження</td>
        </tr>
    </thead>
    <tbody>
        <tr>
            <td>Authority</td>
            <td>name</td>
            <td>Назва повноваження</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td>Role</td>
            <td>name</td>
            <td>Назва ролі</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td rowspan="5">User</td>
            <td>role</td>
            <td>Назва ролі користувача</td>
            <td>role</td>
            <td>Не порожнє значення</td>
        </tr>
        <tr>
            <td>name</td>
            <td>Ім'я користувача</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td>surname</td>
            <td>Прізвище користувача</td>
            <td>текст</td>
            <td></td>
        </tr>
        <tr>
            <td>sculpture</td>
            <td>Колекція зроблених скульптур</td>
            <td>перелік sculpture</td>
            <td></td>
        </tr>
        <tr>
            <td>balance</td>
            <td>Кількість грошей на рахунку користувача</td>
            <td>чисельний</td>
            <td>Не меншний за 0</td>
        </tr>
        <tr>
            <td>Material</td>
            <td>name</td>
            <td>Назва матеріалу скульптури</td>
            <td>текст</td>
            <td>Не порожнє значення</td>
        </tr>
        <tr>
            <td>SculptureType</td>
            <td>name</td>
            <td>Назва типу скульптури</td>
            <td>текст</td>
            <td>Не порожнє значення</td>
        </tr>
        <tr>
            <td rowspan="6">Sculpture</td>
            <td>name</td>
            <td>Назва скульптури</td>
            <td>текст</td>
            <td>Щонайменш 5 символів</td>
        </tr>
        <tr>
            <td>description</td>
            <td>Опис скульптури</td>
            <td>текст</td>
            <td></td>
        </tr>
        <tr>
            <td>material</td>
            <td>матеріал скульптури</td>
            <td>перелік матеріалів</td>
            <td>Щонайменш 1 жанр</td>
        </tr>
        <tr>
            <td>SculptureType</td>
            <td>Тип скульптури</td>
            <td>sculptureType</td>
            <td>Не порожнє значення</td>
        </tr>
        <tr>
            <td>cost</td>
            <td>Вартість скульптури</td>
            <td>чисельний</td>
            <td>Не меншний за 0</td>
        </tr>
        <tr>
            <td>author</td>
            <td>Автор скульптури</td>
            <td>user</td>
            <td></td>
        </tr>
    </tbody>
</table>
