import Home from "./pages/Home.tsx";
import {BrowserRouter, Navigate, Route, Routes} from "react-router-dom";
import Search from './pages/Search.tsx';
import Header from "./components/Header.tsx";
import Footer from "./components/Footer.tsx";
import DoctorDetail from "./pages/DoctorDetail.tsx";


function App() {

    return (
        <BrowserRouter>
            <Header />
            <div className="App">
                <Routes>
                    <Route path="/" element={<Navigate to="/home" />} />
                    <Route path={"/home"} index element={<Home/>}/>
                    <Route path={"/search"} element={<Search/>}/>
                    <Route path={"/doctor/details"} element={<DoctorDetail/>}/>
                </Routes>
            </div>

            <Footer />
        </BrowserRouter>
    )
}

export default App
