import os
import pandas as pd
import matplotlib.pyplot as plt

DATA_FILE = "expenses.csv"
COLUMNS = ["date", "category", "description", "amount"]


def load_expenses():
    """Load saved expenses from CSV."""
    if os.path.exists(DATA_FILE):
        return pd.read_csv(DATA_FILE)
    return pd.DataFrame(columns=COLUMNS)


def save_expenses(df):
    """Save expenses to CSV."""
    df.to_csv(DATA_FILE, index=False)


def add_expense(df):
    """Collect and add one expense."""
    print("\n--- Add Expense ---")

    date = input("Enter purchase date (e.g. 2026-09-28): ").strip()
    category = input(
        "Enter category (food, shopping, skincare, travel, charity, etc.): "
    ).strip()
    description = input("Enter a short description: ").strip()

    while True:
        try:
            amount = float(input("Enter amount spent: "))
            if amount < 0:
                print("Amount cannot be negative.")
                continue
            break
        except ValueError:
            print("Please enter a valid number.")

    new_expense = pd.DataFrame(
        [[date, category, description, amount]],
        columns=COLUMNS
    )

    df = pd.concat([df, new_expense], ignore_index=True)
    save_expenses(df)

    print("Expense recorded successfully.")
    return df


def view_expenses(df):
    """Display all recorded expenses."""
    print("\n--- Your Expenses ---")

    if df.empty:
        print("No expenses recorded yet.")
        return

    print(df.to_string(index=False))


def show_total(df):
    """Display total spending."""
    print("\n--- Total Spending ---")

    if df.empty:
        print("No expenses recorded yet.")
        return

    total = pd.to_numeric(df["amount"], errors="coerce").fillna(0).sum()
    print(f"Total amount spent: ₹{total:.2f}")


def show_category_chart(df):
    """Display spending distribution by category."""
    print("\n--- Spending by Category ---")

    if df.empty:
        print("No expenses recorded yet.")
        return

    category_sums = (
        df.assign(amount=pd.to_numeric(df["amount"], errors="coerce").fillna(0))
        .groupby("category")["amount"]
        .sum()
    )

    if category_sums.empty:
        print("No valid expense amounts available for the chart.")
        return

    plt.figure(figsize=(7, 7))
    plt.pie(
        category_sums,
        labels=category_sums.index,
        autopct="%1.1f%%"
    )
    plt.title("Spending by Category")
    plt.show()


def main():
    """Run the expense tracker."""
    print("================================")
    print("       EXPENSE TRACKER")
    print("================================")

    expenses = load_expenses()

    while True:
        print("\nWhat would you like to do?")
        print("1. Add an expense")
        print("2. View expenses")
        print("3. Show total spending")
        print("4. Show spending chart")
        print("5. Exit")

        choice = input("Enter your choice (1-5): ").strip()

        if choice == "1":
            expenses = add_expense(expenses)
        elif choice == "2":
            view_expenses(expenses)
        elif choice == "3":
            show_total(expenses)
        elif choice == "4":
            show_category_chart(expenses)
        elif choice == "5":
            print("Thank you for using Expense Tracker.")
            break
        else:
            print("Invalid choice. Please enter a number from 1 to 5.")


if __name__ == "__main__":
    main()
