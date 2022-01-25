import React,{ useState, createContext } from "react";

export const ApplicationContext = createContext();

export const ApplicationContextConsumer=ApplicationContext.Consumer;

function ApplicationContextProvider(props)
{
    const [about_me] = useState('');

    function getabout_me()
    {
        return 'About me';
    }

const value = { about_me, getabout_me };

    return(
        <ApplicationContext value={value}>
            {props.children}
        </ApplicationContext>
    )
}
export default ApplicationContextProvider;