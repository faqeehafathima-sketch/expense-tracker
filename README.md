# Expense Tracker

A Python-based personal expense tracking application built to record, manage, and visualize day-to-day spending.

## Overview

The application takes expense details from the user, validates the input, stores the records in a structured format, and provides basic spending analysis and visualization.

The project focuses on practical Python programming, data handling, and visualization rather than a large framework-based application.

## Key Features

- Add and record expenses with date, category, description, and amount
- Store expense records in CSV format
- Load existing records when the application starts
- Display recorded expenses
- Calculate total spending
- Group expenses by category
- Generate a category-wise pie chart
- Validate expense amounts and handle invalid input

## Technologies Used

- **Python** — application logic and user interaction
- **Pandas** — tabular data handling and analysis
- **Matplotlib** — expense visualization
- **CSV** — lightweight local data storage

## Project Structure

```text
expense-tracker/
├── expense_tracker.py
├── requirements.txt
├── .gitignore
└── README.md
```

The `expenses.csv` file is created locally when expenses are recorded. It is excluded from the repository because it can contain personal spending information.

## How It Works

```text
Enter Expense
     ↓
Validate Input
     ↓
Create / Update DataFrame
     ↓
Save Records to CSV
     ↓
Analyze Spending
     ↓
Display Results & Chart
```

## Implementation

The main application is written in Python using functions for the individual operations.

The implementation includes:

- User input handling and validation
- Exception handling for invalid numeric values
- Reading and writing CSV data
- Pandas DataFrames for structured expense records
- `groupby()` for category-wise spending analysis
- Matplotlib for generating the spending chart
- Local file persistence so records remain available between runs

## Running the Project

Install the required packages:

```bash
pip install -r requirements.txt
```

Run the application:

```bash
python expense_tracker.py
```

## Future Improvements

- Monthly and yearly spending summaries
- Budget tracking and alerts
- Date-based filtering
- Edit and delete expense records
- Monthly spending trend charts
- Streamlit interface
- SQLite database support

## Author

**Faqeeha Fathima**

B.Tech Artificial Intelligence & Data Science
