![image](https://github.com/JackHenry-G/EsgChallenges/assets/78259929/94cbb340-fbb4-41ba-ae27-7da0360441ea)

To run the API server:
- navigate to the 'customers' spring boot project in your terminal
- Execute 'docker-compose up -d' to start the postgresql database instance.
- Execute 'mvn spring-boot:run' to start the API server

To parse a CSV and send the details to the server:
- Navigate to the 'csvreader' project in your terminal
- Execute the main class to parse the CSV, submit it to the API and save the details in the database.
