import './App.css'

import DoctorItemCard from "./components/DoctorItemCard.tsx";

import Home from "./pages/Home.tsx";
import Header from "./components/Header.tsx";
import Footer from "./components/Footer.tsx";


function App() {

  return (
    <>
        <Header/>
        <div className="p-4">
          {/* Hiển thị danh sách bác sĩ theo dạng lưới 4 cột */}
          <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-6">
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
              <DoctorItemCard/>
          </div>
      </div>
        <Footer/>
    </>

  )
}

export default App
