import Home from "./pages/Home.tsx";
import {BrowserRouter, Route, Routes} from "react-router-dom";
import Search from './pages/Search.tsx';
import Header from "./components/Header.tsx";
import Footer from "./components/Footer.tsx";


function App() {

    return (
        <BrowserRouter>
            <Header />
            <div className="App">
                <Routes>
                    <Route path={"/home"} index element={<Home/>}/>
                    <Route path={"/search"} element={<Search/>}/>
                </Routes>
            </div>

            <Footer />
        </BrowserRouter>
    )
}

export default App
