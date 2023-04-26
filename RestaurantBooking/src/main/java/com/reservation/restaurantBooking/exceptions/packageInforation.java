package com.reservation.restaurantBooking.exceptions;
 /**
  * Contains custom application-specific exception classes.
  *
  * BaseException: This class is intended to be subclassed by application-specific exceptions.
  * It extends the RuntimeException class and provides constructors to create an instance of the exception with a message
  * and a cause. It is used as the base class for all exceptions in the application.
  *
  * InvalidReservationRequestException: This exception is thrown when a request for reservation is invalid.
  * It extends the BaseException class and has properties for the invalid property and value.
  * The constructor takes the property and value as parameters and uses them to construct an error message.
  *
  * ReservationNotFoundException: This exception is thrown when a reservation is not found by given property and value.
  * It extends the BaseException class and has properties for the property and value used to search for the reservation.
  * The constructor takes the property and value as parameters and uses them to construct an error message.
  *
  * UserNotFoundException: This exception is thrown when a user is not found.
  * It extends the BaseException class and has constructors to create an instance of the exception with a message and a cause.
  * The message parameter can be used to provide additional context about the error.
  *
  *
  *
  *  Містяться кастомні класи-винятків, зі специфікацією для конкретних цілей.
  *
  *    BaseException: Цей клас призначений для створення специфічних підкласів для програми.
  *    Він розширює клас RuntimeException і надає конструктори для створення екземпляра виключення з повідомленням та причиною.
  *    Він використовується як базовий клас для всіх винятків у програмі.
  *
  *    Виключення InvalidReservationRequestException: Цей виняток генерується, коли запит на бронювання є недійсним.
  *    Він розширює клас BaseException і має властивості для недійсної властивості та значення.
  *   Конструктор отримує властивість і значення в якості параметрів і використовує їх для створення повідомлення про помилку.
  *
  *    ReservationNotFoundException: Це виключення генерується, коли бронювання не знайдено за заданою властивістю та значенням.
  *    Він розширює клас BaseException і має властивості для властивості та значення, які використовуються для пошуку бронювання.
  *    Конструктор отримує властивість і значення як параметри і використовує їх для побудови повідомлення про помилку.
  *
  *    UserNotFoundException: Це виключення генерується, коли користувача не знайдено.
  *    Він розширює клас BaseException і має конструктори для створення екземпляра виключення з повідомленням і причиною.
  *   Параметр message можна використовувати для надання додаткового контексту про помилку.
  */