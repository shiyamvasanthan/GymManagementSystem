INSERT INTO Members (email_id, member_name, weight_goal, time_goal, heart_rate, bmi)
VALUES
('shiyam@gmail.com', 'Shiyam', 140, '2024-09-23', 107, 23),
('james@gmail.com', 'James', 185, '2024-06-15', 120, 27),
('mike@gmail.com', 'Mike', 160, '2025-01-01', 75, 21);

INSERT INTO Trainer (trainer_id, trainer_name, price, available_time)
VALUES
(1, 'Cooper', 300, '2024-04-12'),
(2, 'Conley', 140, '2024-04-13'),
(3, 'Lebron', 140, '2024-04-15');

INSERT INTO Train (email_id, trainer_id, train_time)
VALUES
('shiyam@gmail.com', 1, '2024-04-12');

INSERT INTO Dashboard (email_id, exercise_routines, achievements, stats)
VALUES
('shiyam@gmail.com', 'Push Pull Legs', 'Fastest 100 meter sprint', 'Life expectancy: 80yrs'),
('james@gmail.com', 'Full Body 3x a Week', NULL, NULL),
('mike@gmail.com', 'Upper/Lower 4x a week', NULL, NULL);

INSERT INTO Administrator (admin_id)
VALUES
(1),
(2),
(3);

INSERT INTO Room (room_id, room_name)
VALUES
(1, 'Cardio Room'),
(2, 'Sauna'),
(3, 'Change Room'),
(4, 'Group Fitness Room');

INSERT INTO Booking (admin_id, room_id)
VALUES
(1, 3);

INSERT INTO Equipment (equipment_id, equipment_name)
VALUES
(1, 'Dumbbells'),
(2, 'Squat Rack'),
(3, 'Bench');

INSERT INTO Monitor (admin_id, equipment_id, quality)
VALUES
(1, 1, 'Good'),
(2, 2, 'Bad'),
(3, 3, 'Decent');

INSERT INTO Classes (class_id, class_name)
VALUES
(1, 'Pilates'),
(2, 'Zumba'),
(3, 'Yoga');

INSERT INTO Updates (admin_id, class_id, new_time)
VALUES
(2, 1, '2024-04-30');

INSERT INTO Billing (amount, billing_date)
VALUES
(200, '2024-04-13');

INSERT INTO Processing (admin_id, billing_id)
VALUES
(3, 1);

INSERT INTO Register (email_id, class_id)
VALUES
('shiyam@gmail.com', 3);








