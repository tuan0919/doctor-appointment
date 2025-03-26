import Home from "./pages/Home.tsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Search from './pages/Search.tsx';


function App() {

    return (
        <BrowserRouter>
            <div className="App">
                <Routes>
                    <Route index element={<Home/>}/>
                    <Route path={"/search"} element={<Search/>}/>
                </Routes>
            </div>
        </BrowserRouter>
    )
}

export default App
