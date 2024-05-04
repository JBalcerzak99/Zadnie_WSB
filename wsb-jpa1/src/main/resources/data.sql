insert into address (id, addressLine1, addressLine2, city, postalCode)
values
(1, 'ul. Kwiatowa', '2', 'Warszawa', '00-001'),
(2, 'ul. Leśna', '7', 'Kraków', '30-005'),
(3, 'ul. Słoneczna', '10', 'Gdańsk', '80-010'),
(4, 'ul. Polna', '3', 'Poznań', '60-004'),
(5, 'ul. Zielona', '8', 'Wrocław', '50-008'),
(6, 'ul. Piękna', '4B', 'Łódź', '90-015'),
(7, 'ul. Morska', '22', 'Szczecin', '70-022'),
(8, 'ul. Jasna', '7', 'Katowice', '40-007'),
(9, 'ul. Nowa', '12', 'Gdynia', '81-012'),
(10, 'ul. Wiosenna', '6', 'Bydgoszcz', '85-006');

insert into doctor (id, firstName, lastName, telephoneNumber, email, doctorNumber, specialization)
values
(1, 'Jan', 'Kowalski', '123456789', 'jan.kowalski@example.com', 'DOC001', 'SURGEON'),
(2, 'Anna', 'Nowak', '987654321', 'anna.nowak@example.com', 'DOC002', 'GP'),
(3, 'Piotr', 'Wiśniewski', '555666777', 'piotr.wisniewski@example.com', 'DOC003', 'DERMATOLOGIST'),
(4, 'Magdalena', 'Dąbrowska', '333222111', 'magdalena.dabrowska@example.com', 'DOC004', 'OCULIST'),
(5, 'Marcin', 'Lis', '444555666', 'marcin.lis@example.com', 'DOC005', 'SURGEON'),
(6, 'Katarzyna', 'Wójcik', '777888999', 'katarzyna.wojcik@example.com', 'DOC006', 'GP'),
(7, 'Paweł', 'Kamiński', '666777888', 'pawel.kaminski@example.com', 'DOC007', 'DERMATOLOGIST'),
(8, 'Alicja', 'Zając', '111222333', 'alicja.zajac@example.com', 'DOC008', 'OCULIST'),
(9, 'Tomasz', 'Piotrowski', '999888777', 'tomasz.piotrowski@example.com', 'DOC009', 'SURGEON'),
(10, 'Monika', 'Adamczyk', '888999000', 'monika.adamczyk@example.com', 'DOC010', 'GP');


insert into patient (id, firstName, lastName, telephoneNumber, email, patientNumber, dateOfBirth)
values
(1, 'Adam', 'Nowak', '111222333', 'adam.nowak@example.com', 'PAT001', '1990-05-15'),
(2, 'Ewa', 'Kowalska', '444555666', 'ewa.kowalska@example.com', 'PAT002', '1985-10-20'),
(3, 'Marek', 'Wiśniewski', '777888999', 'marek.wisniewski@example.com', 'PAT003', '1978-03-25'),
(4, 'Karolina', 'Dąbrowska', '222333444', 'karolina.dabrowska@example.com', 'PAT004', '1995-12-10'),
(5, 'Tomasz', 'Lis', '555666777', 'tomasz.lis@example.com', 'PAT005', '1980-07-05'),
(6, 'Monika', 'Wójcik', '888999000', 'monika.wojcik@example.com', 'PAT006', '1993-09-30'),
(7, 'Anna', 'Kamińska', '333444555', 'anna.kaminska@example.com', 'PAT007', '1975-04-12'),
(8, 'Paweł', 'Zając', '666777888', 'pawel.zajac@example.com', 'PAT008', '1987-11-17'),
(9, 'Alicja', 'Piotrowska', '999000111', 'alicja.piotrowska@example.com', 'PAT009', '1992-02-28'),
(10, 'Katarzyna', 'Adamczyk', '121314151', 'katarzyna.adamczyk@example.com', 'PAT010', '1988-08-22');

insert into medical_treatment (id, description, type)
values
(1, 'Abdominal ultrasound examination', 'USG'),
(2, 'Electrocardiogram', 'EKG'),
(3, 'Chest X-ray', 'RTG'),
(4, 'Thyroid ultrasound', 'USG'),
(5, 'Exercise electrocardiogram', 'EKG');

insert into visit (id, description, time, doctor_id, patient_id, medical_treatment_id)
values
(1, 'Regular checkup', '2024-05-03 10:00:00', 1, 1, 2),
(2, 'Follow-up appointment', '2024-05-05 14:30:00', 2, 3, 2),
(3, 'Diagnostic tests', '2024-05-07 09:15:00', 3, 3, 3),
(4, 'Treatment consultation', '2024-05-10 11:45:00', 4, 4, 4),
(5, 'Vaccination', '2024-05-12 13:20:00', 5, 5, 5),
(6, 'Therapy session', '2024-05-15 16:00:00', 6, 3, 5),
(7, 'Pre-surgery examination', '2024-05-18 08:30:00', 7, 7, 2),
(8, 'Eye examination', '2024-05-20 10:45:00', 8, 8, 3),
(9, 'Hearing test', '2024-05-23 12:15:00', 9, 7, 4),
(10, 'Urinary tract infection check', '2024-05-25 15:30:00', 10, 1, 5);





