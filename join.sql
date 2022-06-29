select * from employee;

select * from department;

-- Joing Query
select * from employee e, department d
where e.dno = d.dno;

-- Join Query2
SELECT ENO, ENAME, JOB, MANAGER, HIREDATE, SALARY, COMMISSION, DNO,
      DNO, DNAME, LOC
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DNO = D.DNO