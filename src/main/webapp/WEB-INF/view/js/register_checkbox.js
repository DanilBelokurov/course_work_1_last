$(document).ready(function() {

  // Добавляем значения
  var val_data = {
    "5711": "5711",
    "5712": "5712",
    "5721": "5721",
    "5722": "5722",
    "5723": "5723"
  };

  var input = $('[name="other1"]');

  // Создаем общий блок с классом
  var val_cont = document.createElement('div');
  $(val_cont).addClass("dropdown");

  // Создаем кнопку открытия списка и поле для записи значений
  $(val_cont).append("<a href='javascript:void(0);'><span class='open'>Select your group</span><span class='value'></span></a>");

  // Создаем выпдающий список и вкладываем в общий блок
  var ul = document.createElement('ul');

  for (elem in val_data) {
    $(ul).append("<li><input type='checkbox' value='" + elem + "' id='" + elem + "'><label for='" + elem + "'>" + val_data[elem] + "</label></li>");
  }
  $(ul).appendTo(val_cont);
  $(ul).hide();

  // Размещаем общий блок после нужного input-а
  $(input).after(val_cont);

  // Скрываем/открываем выпадающий список
  $(".dropdown a").on('click', function() {
    $(".dropdown ul").slideToggle('fast');
  });

  $('.dropdown ul input[type="checkbox"]').on('click', function() {
    var inputValue, innerObj = {};
    
    /* проверяем value текстового инпута. это необходимо для очистки
       от лишних запятых при удалении всех элементов и накликивания
       чекбоксов заново. если эту проверку не делать, то пустой инпут
       добавляется как пустой элемент массива */
    if(input.val()) { 
      /* если инпут не пустой, то закидываем данные из него в массив
         по разделителю ", " */
      inputValue = input.val().split(', ')
    } else {
      inputValue = []; // если пустой - присваиваем переменно пустой массив
    };
    
    /* промежуточный объект нам необходим для составления массива
       только с уникальными элементами */
    inputValue.forEach(function(item) {
      innerObj[item] = true;
    });
    
    /* если чекбокс активен — добавляем его value как ключ к объекту, 
       а если нет — удаляем этот ключ */
    if ($(this).is(':checked')) {
      innerObj[$(this).val()] = true;
    } else {
      delete innerObj[$(this).val()];
    }
    
    inputValue = Object.keys(innerObj); // преобразуем ключи объекта в массив
    input.val(inputValue.join(', ')); // преобразуем массив в строку, разделяя элементы ", " и записываем в value инпута
  });
  
  // новая функция
  $('.check').click(function() {
    var valuesArray = input.val().split(', '), // собираем данные из инпута в массив, разделитель ", "
        $checkboxes = $(ul).find('li input').removeClass('protected'); // удаляем со всех инпутов класс
        
    $.each(valuesArray, function(index, value) { // проходимся циклом по собранному массиву из инпутов
      $checkboxes.each(function() { // для каждого значение запускаем цикл по всем чекбоксам
        if ($(this).val() === value) { // и если value инпута равно элементу из собранного массива 
          $(this).prop('checked', true).addClass('protected'); // "чекаем" чекбокс и добавляем ему класс, чтобы на следующем условии чекбокс не стал обратно не выделенным

          return true; // уходим на следующую итерацию
        } else if ( !$(this).hasClass('protected') ) { // если у чекбокса нет класса protected
          $(this).prop('checked', false); // то снимаем выделение с чекбокса
        }
      });
    });
  });
});