import random
from datetime import date, timedelta

# Configure output file
output_file = "insert_statements.sql"

# Generate random names
first_names = ["John", "Jane", "Alice", "Bob", "Charlie", "Diana", "Eve", "Frank", "Grace", "Hank"]
last_names = ["Smith", "Johnson", "Brown", "Taylor", "Anderson", "Thomas", "Jackson", "White", "Harris", "Martin"]

# Starting date for empjoindate
start_date = date(2000, 1, 1)

# Total number of records to generate
num_records = 10_000  # Changed to 10,000

# Open file for writing
with open(output_file, "w") as file:
    for empid in range(1, num_records + 1):
        # Randomly select first and last names
        empfname = random.choice(first_names)
        emplname = random.choice(last_names)
        
        # Generate a unique empjoindate
        empjoindate = start_date + timedelta(days=empid % 10000)  # Loops through 10,000 days
        
        # Create INSERT statement
        insert_statement = f"INSERT INTO employees (empid, empfname, emplname, empjoindate) " \
                           f"VALUES ({empid}, '{empfname}', '{emplname}', '{empjoindate}');\n"
        
        # Write to file
        file.write(insert_statement)

print(f"Generated {num_records} INSERT statements in {output_file}")
