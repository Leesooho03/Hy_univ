import React, { useState } from "react";
import axios from "axios";
import ChatMessage from "./ChatMessage";
import ChatInput from "./ChatInput";

const ChatWindow = () => {
    const [messages, setMessages] = useState([]);

    const addMessage = (message, isUser) => {
        setMessages((prevMessages) => [...prevMessages, { text: message, isUser }]);
    };

    const handleSubmit = async (message) => {
        // 사용자 메시지를 추가합니다.
        addMessage(message, true);

        try {
            // 첫 번째 URL로 요청을 보냅니다.
            const firstUrlResponse = await axios.post("http://192.168.1.16:9090/ask", {
                prompt: message,
            });

            // 응답이 오면 처리하고 함수를 종료합니다.
            if (firstUrlResponse.data) {
                addMessage(firstUrlResponse.data, false);
                return;
            }
        } catch (firstUrlError) {
            console.error("Error fetching response from the first URL:", firstUrlError);
        }

        try {
            // 두 번째 URL로 요청을 보냅니다.
            const secondUrlResponse = await axios.post("http://localhost:9090/ask", {
                prompt: message,
            });

            // 응답이 오면 처리합니다.
            if (secondUrlResponse.data) {
                addMessage(secondUrlResponse.data, false);
            }
        } catch (secondUrlError) {
            console.error("Error fetching response from the second URL:", secondUrlError);
        }
    };


    return (
        <div className="chat-window">
            <div className="chat-messages">
                {messages.map((message, index) => (
                    <ChatMessage
                        key={index}
                        message={message.text}
                        isUser={message.isUser}
                    />
                ))}
            </div>

            <ChatInput onSubmit={handleSubmit} />
        </div>
    );
};

export default ChatWindow;