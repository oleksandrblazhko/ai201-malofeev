|Опис вхідних умов|Правильний/неправильний <br> клас еквівалентності|Опис значень вхідних даних|
|:-|:-:|:-|
|1) Значення *sculptureId* у діапазоні [0;1000000000]<br>2) Значення *sculptureType* співпадає з одним із: "Free", "Trial" або "Paid";| Правильний | *sculptureId* = *12* <br> *sculptureType* = *Free*|
|1) Значення *sculptureId* *НЕ* у діапазоні [0;1000000000]<br>2) Значення *sculptureType* співпадає з одним із: "Free", "Trial" або "Paid";| Неправильний | *sculptureId* = *1000000000000* <br> *sculptureType* = *Free*|
|1) Значення *sculptureId* у діапазоні [0;1000000000]<br>2) Значення *sculptureType* НЕ співпадає з одним із: "Free", "Trial" або "Paid";| Неправильний | *sculptureId* = *10* <br> *sculptureType* = *Sale*|
|1) Значення *sculptureId* НЕ у діапазоні [0;1000000000]<br>2) Значення *sculptureType* НЕ співпадає з одним із: "Free", "Trial" або "Paid";| Неправильний | *sculptureId* = *-100* <br> *sculptureType* = *Sold*|
