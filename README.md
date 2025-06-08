# 🚀 Android Activity Launch Modes

В Android существует четыре launchMode, которые определяют поведение `Activity` при запуске: как создаётся новый экземпляр, где он размещается в стеке задач (task), и как система обрабатывает повторные вызовы.

---

## 1. `standard` (режим по умолчанию)

- Каждый вызов создаёт **новый экземпляр** Activity, даже если она уже есть в стеке.
- Размещается в том же task, из которого запущена.
- Не вызывает `onNewIntent()`.

**Использование**:
```xml
<activity android:name=".StandardActivity" />
```

---

## 2. `singleTop`

- Если Activity уже **на вершине стека**, новый экземпляр **не создаётся**.
- Вместо этого вызывается `onNewIntent()`.
- Подходит для уведомлений, повторных нажатий на кнопку и т. д.

**Использование**:
```xml
<activity android:name=".SingleTopActivity"
    android:launchMode="singleTop" />
```

---

## 3. `singleTask`

- Если Activity уже существует **где-то в task**, система переиспользует её и вызывает `onNewIntent()`.
- Все Activity **выше неё в стеке удаляются**.
- Если экземпляра нет, создаётся **новый task** (если запущена с `FLAG_ACTIVITY_NEW_TASK`).

**Использование**:
```xml
<activity android:name=".SingleTaskActivity"
    android:launchMode="singleTask" />
```

---

## 4. `singleInstance`

- Activity живёт в **отдельной задаче** (task), и она **единственная** в этом task.
- Повторные вызовы направляются в `onNewIntent()`.
- Используется для экранов, которые должны быть полностью изолированы.

**Использование**:
```xml
<activity android:name=".SingleInstanceActivity"
    android:launchMode="singleInstance" />
```

---

## 📊 Сравнение launchMode

| Launch Mode       | Новый экземпляр | Один в task | Отдельный task | `onNewIntent()` |
|-------------------|------------------|--------------|------------------|------------------|
| `standard`        | ✅               | ❌           | ❌               | ❌               |
| `singleTop`       | ❌ (если сверху) | ❌           | ❌               | ✅               |
| `singleTask`      | ❌               | ✅           | 🚫/✅             | ✅               |
| `singleInstance`  | ❌               | ✅           | ✅               | ✅               |

---

## ✅ Практические рекомендации

| Сценарий                            | Подходящий launchMode |
|-------------------------------------|------------------------|
| Обычные экраны                      | `standard`             |
| Обработка уведомлений               | `singleTop`            |
| Главный/домашний экран              | `singleTask`           |
| Изолированные экраны (видеозвонки)  | `singleInstance`       |

---

## 🛠️ Дополнительно

- Комбинируется с Intent флагами:  
  `FLAG_ACTIVITY_NEW_TASK`, `FLAG_ACTIVITY_CLEAR_TOP`, `FLAG_ACTIVITY_SINGLE_TOP`
- Для анализа задач:
  ```bash
  adb shell dumpsys activity activities
  ```

---