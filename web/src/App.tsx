import Home from "./pages/Home.tsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";

function App() {

    return (
        <BrowserRouter>
            <div className="App">
                <Routes>
                    <Route path="/search">
                        <Route index element={<Home/>}/>
                    </Route>
                </Routes>
            </div>
        </BrowserRouter>
    )
}

export default App
