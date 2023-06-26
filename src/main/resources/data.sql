-- ユーザーテーブルデータ
INSERT INTO users(name, email,password) VALUES('チャット君', 'chat@a.com', 'himitu');


-- チャットテーブルデータ
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, 'ここにメッセージが表示されます', 1, null);
INSERT INTO chats(user_id, text, address_id, date) VALUES(1, '楽しんで', 1, null);