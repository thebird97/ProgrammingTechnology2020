Adott egy bérszámfejtõ rendszer:
- nyilvántartja az alkalmazottakat (név, törzsszám, fizetés)
- nyilvántartja, hogy ki melyik napon mikor érkezett és távozott
- a cégnél rugalmas munkaidõben dolgoznak, heti 40 órában szerzõdve
- napi 30 perc ebéd idõ van, ami nem számít bele a munkaidõbe
- a túlórát 120% fizetéssel jutalmazzák
- havi átlagban a napi 8 óránál kevesebb munkáért arányosan kevesebb fizetés jár

CREATE DATABASE Salary;

DROP TABLE IF EXISTS Salary.Employee;
DROP TABLE IF EXISTS Salary.Workhours;

CREATE TABLE Employee(
  ID  INT NOT NULL PRIMARY KEY AUTO_INCREMENT,
  Name VARCHAR(100) NOT NULL,
  Salary INT NOT NULL
);

CREATE TABLE Workhours(
  FK_EmployeeID INT NOT NULL REFERENCES Employee(ID),
  Day     DATE NOT NULL,
  Arrival TIME NOT NULL,
  Leaving TIME NOT NULL
);



USE Salary;

INSERT INTO Employee (ID,Name,Salary) VALUES(1, "Mary K. Nanny", 54000);
INSERT INTO Employee (ID,Name,Salary) VALUES(2, "Lazy Daisy", 47000);
INSERT INTO Employee (ID,Name,Salary) VALUES(3, "Sergey Stachanov", 40000);

INSERT INTO Workhours VALUES(1, "2018-02-01", "08:00", "16:30");
INSERT INTO Workhours VALUES(1, "2018-02-02", "08:00", "16:30");
INSERT INTO Workhours VALUES(1, "2018-02-05", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-06", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-07", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-08", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-09", "08:00", "14:30");
INSERT INTO Workhours VALUES(1, "2018-02-12", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-13", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-14", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-15", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-16", "08:00", "14:30");
INSERT INTO Workhours VALUES(1, "2018-02-19", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-20", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-21", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-22", "07:00", "16:00");
INSERT INTO Workhours VALUES(1, "2018-02-23", "08:00", "14:30");
INSERT INTO Workhours VALUES(1, "2018-02-26", "08:00", "16:30");
INSERT INTO Workhours VALUES(1, "2018-02-27", "08:00", "16:30");
INSERT INTO Workhours VALUES(1, "2018-02-28", "08:00", "16:30");

INSERT INTO Workhours VALUES(2, "2018-02-01", "09:10", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-02", "09:20", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-05", "09:00", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-06", "09:15", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-07", "09:00", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-08", "09:30", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-09", "09:00", "14:30");
INSERT INTO Workhours VALUES(2, "2018-02-12", "09:10", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-13", "09:00", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-14", "09:10", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-15", "09:00", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-16", "09:40", "14:30");
INSERT INTO Workhours VALUES(2, "2018-02-19", "09:00", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-20", "09:20", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-21", "09:25", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-22", "09:10", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-23", "09:15", "14:30");
INSERT INTO Workhours VALUES(2, "2018-02-26", "09:25", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-27", "09:40", "16:00");
INSERT INTO Workhours VALUES(2, "2018-02-28", "09:00", "16:00");

INSERT INTO Workhours VALUES(3, "2018-02-01", "07:00", "16:30");
INSERT INTO Workhours VALUES(3, "2018-02-02", "07:00", "16:30");
INSERT INTO Workhours VALUES(3, "2018-02-05", "07:00", "16:50");
INSERT INTO Workhours VALUES(3, "2018-02-06", "07:00", "16:30");
INSERT INTO Workhours VALUES(3, "2018-02-07", "07:00", "16:50");
INSERT INTO Workhours VALUES(3, "2018-02-08", "07:00", "16:50");
INSERT INTO Workhours VALUES(3, "2018-02-09", "07:00", "16:30");
INSERT INTO Workhours VALUES(3, "2018-02-12", "07:00", "16:50");
INSERT INTO Workhours VALUES(3, "2018-02-13", "07:00", "17:00");
INSERT INTO Workhours VALUES(3, "2018-02-14", "07:00", "17:00");
INSERT INTO Workhours VALUES(3, "2018-02-15", "07:00", "17:00");
INSERT INTO Workhours VALUES(3, "2018-02-16", "07:00", "16:30");
INSERT INTO Workhours VALUES(3, "2018-02-19", "07:00", "17:00");
INSERT INTO Workhours VALUES(3, "2018-02-20", "07:00", "17:00");
INSERT INTO Workhours VALUES(3, "2018-02-21", "07:00", "17:00");
INSERT INTO Workhours VALUES(3, "2018-02-22", "07:00", "17:00");
INSERT INTO Workhours VALUES(3, "2018-02-23", "07:00", "16:30");
INSERT INTO Workhours VALUES(3, "2018-02-26", "07:00", "16:30");
INSERT INTO Workhours VALUES(3, "2018-02-27", "07:00", "16:30");
INSERT INTO Workhours VALUES(3, "2018-02-28", "07:00", "16:30");


use salary;

select id, name from employee, workhours WHERE id NOT IN (SELECT FK_EmployeeID FROM workhours WHERE id = FK_employeeID AND MONTH(day) = 2 AND YEAR(day) = 2018) group by id;


select id, name, salary, SEC_TO_TIME(SUM(TIME_TO_SEC(leaving) - TIME_TO_SEC(arrival))) AS timediff from employee, workhours WHERE id = FK_employeeID AND MONTH(day) = 2 AND YEAR(day) = 2018 
group by id;

SELECT Day, Arrival, Leaving FROM Workhours WHERE FK_EmployeeID = 1 AND
YEAR(Day) = 2018 AND MONTH(Day) = 2;