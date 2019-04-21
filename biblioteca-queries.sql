--1. Who checked out the book 'The Hobbit?'

SELECT m.name,
        b.title
FROM member m
LEFT JOIN checkout_item ci ON m.id = ci.member_id
LEFT JOIN book b ON b.id = ci.book_id
WHERE b.title = 'The Hobbit';

-- Answer: Anand Beck

--2. How many people have not checked out anything?

SELECT COUNT(m.id)
FROM member m
LEFT JOIN checkout_item ci ON m.id = ci.member_id
WHERE ci.book_id IS NULL AND ci.movie_id IS NULL;

-- Answer: 37

-- 3. What books and movies aren't checked out?

SELECT b.title
FROM book b
LEFT JOIN checkout_item ci ON b.id = ci.book_id
WHERE ci.book_id IS NULL;

SELECT m.title
FROM movie m
LEFT JOIN checkout_item ci ON m.id = ci.movie_id
WHERE ci.movie_id IS NULL;

-- Answer:
-- Fellowship of the Ring   
-- 1984                     
-- Tom Sawyer               
-- Catcher in the Rye       
-- To Kill a Mockingbird    
-- Domain Driven Design     
-- Thin Red Line            
-- Crouching Tiger, Hidden D
-- Lawrence of Arabia       
-- Office Space

-- 4. Add the book 'The Pragmatic Programmer', and add yourself as a member. 
--    Check out 'The Pragmatic Programmer'.
--    Use the query from question 1 to verify you have checked it out.

SELECT m.name,
        b.title
FROM member m
LEFT JOIN checkout_item ci ON m.id = ci.member_id
LEFT JOIN book b ON b.id = ci.book_id
WHERE b.title = 'The Pragmatic Programmer';

-- 5. Who has checked out more than one item?

SELECT m.name
FROM member m
LEFT JOIN checkout_item ci ON m.id = ci.member_id
GROUP BY m.id, m.name
HAVING COUNT(ci.member_id) > 1;