def main():
    
    # Отримуємо розмір матриці
    n_rows = int(input("Введіть розмір квадратної матриці: "))
    
    # Ініціалізація зубчастого масиву
    arr = []
    for i in range(n_rows // 2):
        arr.append([''] * (i + 1))  # Верхня частина: кількість елементів збільшується з кожним рядком
    for i in range(n_rows // 2, n_rows):
        arr.append([''] * (i + 1))  # Нижня частина: також збільшується, але з іншою кількістю пробілів

    # Отримуємо символ заповнювач
    filler = ''
    input_flag = False
    while not input_flag:
        filler = input("\nВведіть символ-заповнювач (1 символ): ")
        if len(filler) != 1:
            print("\nНе введено символ заповнювач")
        else:
            input_flag = True

    # Заповнення верхньої частини трикутника
    for i in range(n_rows // 2):
        for j in range(i + 1):
            arr[i][j] = filler
            print(arr[i][j], end=" ")
        print()

    # Заповнення нижньої частини трикутника з вирівнюванням
    for i in range(n_rows // 2, n_rows):
        # Друкуємо порожній простір для вирівнювання
        print("  " * (n_rows // 2), end="")  # Збільшене вирівнювання для нижнього трикутника
        for j in range(i + 1 - n_rows // 2):
            arr[i][j] = filler
            print(arr[i][j], end=" ")
        print()

if __name__ == "__main__":
    main()
