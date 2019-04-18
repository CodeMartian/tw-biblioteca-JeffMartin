SELECT m.name,
        b.title
FROM member m
LEFT JOIN checkout_item ci ON m.id = ci.member_id
LEFT JOIN book b ON b.id = ci.book_id
WHERE b.title = 'The Hobbit';

-- Who checked out the book 'The Hobbit'?
-- Anand Beck