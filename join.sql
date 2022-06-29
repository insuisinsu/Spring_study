select * from employee;

select * from department;

-- Joing Query
select * from employee e, department d
where e.dno = d.dno;

-- Join Query2
SELECT ENO, ENAME, JOB, MANAGER, HIREDATE, SALARY, COMMISSION,
      D.DNO, DNAME, LOC
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DNO = D.DNO

SELECT E.ENO, E.ENAME, E.JOB, E.MANAGER, E.HIREDATE, E.SALARY, E.COMMISSION,
      D.DNO, D.DNAME, D.LOC
FROM EMPLOYEE E, DEPARTMENT D
WHERE E.DNO = D.DNO


-- ����

CREATE TABLE spring_department(
	deptno  NUMBER        PRIMARY KEY,
	dname   VARCHAR2(100) NOT NULL,
	loc     VARCHAR2(100) NOT NULL
);

CREATE TABLE spring_employment(
    empno   number        PRIMARY KEY,
    ename   VARCHAR2(100) NOT NULL,
    sal     NUMBER        NOT NULL,
    deptno  NUMBER        NOT NULL,
    CONSTRAINT fk_spring_deptno FOREIGN KEY(deptno) REFERENCES spring_department(deptno)
);
INSERT INTO spring_department VALUES(10, '������ȹ', '�Ǳ�');
INSERT INTO spring_department VALUES(20, '�ؾ����', '�λ�');
INSERT INTO spring_department VALUES(30, '�������', '�Ǳ�');

INSERT INTO spring_employment VALUES(1, '���ӽ�', 300, 40);
INSERT INTO spring_employment VALUES(1,'���ӽ�',300,10);
INSERT INTO spring_employment VALUES(2,'�ٸ���',500,10);
INSERT INTO spring_employment VALUES(3,'ũ����',400,20);

select * from spring_department;

commit;

SELECT E.EMPNO, E.ENAME, E.SAL, D.DEPTNO, D.DNAME, D.LOC
FROM SPRING_EMPLOYMENT E, SPRING_DEPARTMENT D
WHERE E.DEPTNO = D.DEPTNO;
